# https://github.com/Sjord/jwtcrack/blob/master/jwt2john.py

#I converted the scrtip to be compatible with python3

import sys
from jwt.utils import b64decode
from binascii import hexlify


def jwt2john(jwt):
    """
    Convert signature from base64 to hex, and separate it from the data by a #
    so that John can parse it.
    """
    jwt_bytes = jwt.encode('ascii')
    parts = jwt_bytes.split(b'.')

    data = parts[0] + b'.' + parts[1]
    signature = hexlify(b64decode(str(parts[2])))

    return (data + b'#' + signature).decode('ascii')


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: %s JWT" % sys.argv[0])
    else:
        john = jwt2john(sys.argv[1])
        print(john)