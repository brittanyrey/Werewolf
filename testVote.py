import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

#Update vote
payload = {"voterID": "3393", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "555", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "942", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "111", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "222", 'suspectID': "111"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "444", 'suspectID': "222"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "666", 'suspectID': "777"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "777", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "888", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"voterID": "1234", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))
payload = {"voterID": "555", 'suspectID': "1234"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))
payload = {"voterID": "900", 'suspectID': "666"}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))

print("votes set")

#Players Alive
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/alive', 
			auth=HTTPBasicAuth(username, password))
print("players alive " + r.text)
