# THC Hydra


## Options

	-L <usersames_file>: file containins usernames to be bruteforced
	-P <passwords_file>: file containins passwords to be bruteforced

	-f <ip>: target ip
	-s <port>: target port

	http-post-form: option for brute force https forms


## Usage

How to run hydra to try passwords agains a service (like ssh):

	hydra -L usernames.txt -p 'password' {target_ip} service_name

Bruteforce web requests with a failed condition:

	hydra -l admin -P rockyou.txt -f 94.237.54.42 -s 54747 http-post-form "/:username=^USER^&password=^PASS^:F=Invalid credentials"

Bruteforce web requests with a Succes condition

	hydra -l admin -P rockyou.txt -f 94.237.54.42 -s 54747 http-post-form "/:username=^USER^&password=^PASS^:S=302"
	hydra -l admin -P rockyou.txt -f 94.237.54.42 -s 54747 http-post-form "/:username=^USER^&password=^PASS^:S=Dashboard"