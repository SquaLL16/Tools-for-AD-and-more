# hashcat

## usage

	hashcat -a <attack_mode> -m <hash_type> <wordlist_path>

	Use hashid <hash> -m to find the hash_type or https://hashcat.net/wiki/doku.php?id=example_hashes
	Example : hashid '$1$pdQG$o8nrSzsGXeaduXrjlvKc91' -m


## rules

	hashcat <hash> <path_to_dictionary> -r /usr/share/hashcat/rules/best64.rule


## Examples

Using the rockyou.txt to break an hash

	hashcat -a 0 -m <hash_type> <hash of path_to_hash_file> /usr/share/wordlist/rockyou.txt