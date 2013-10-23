import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"


#Update location
payload = {"userID": "3393", 'lat': 41, 'lng':80}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "555", 'lat': 40.45678, 'lng':80.1}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "900", 'lat': 48, 'lng':82.6789}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "111", 'lat': 43, 'lng':78.1234}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "222", 'lat': 42.1234, 'lng':81.9}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "444", 'lat': 39.2134, 'lng':80.234}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "666", 'lat': 38.1234, 'lng':81.4353}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "777", 'lat': 40.555, 'lng':81.2}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "888", 'lat': 41.44, 'lng':80.654}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "1234", 'lat': 42.1234, 'lng': 88.234}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))
payload = {"userID": "555", 'lat': 41.234, 'lng': 80.2}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))
payload = {"userID": "900", 'lat': 40.12, 'lng':80.87}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

print("location")


#Players Alive
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/alive', 
			auth=HTTPBasicAuth(username, password))
print("players alive " + r.text)
