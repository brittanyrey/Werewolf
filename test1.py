import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

#Home Page
r = requests.get('http://mighty-sea-1005.herokuapp.com/', 
			auth=HTTPBasicAuth(username, password))
print(r.text)

#Add User
payload = {'id' : '3393', "firstName" : "Brittany", 
"lastName" : "Reynoso", "username" : "brittanyR", "hashedPassword" : "yes", 
"imageURL" : "http:...", "isAdmin" : True}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', 
	data = payload, auth=HTTPBasicAuth(username, password))

payload = {'id' : '555', "firstName" : "John", 
"lastName" : "Doe", "username" : "JD93", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {'id' : '942', "firstName" : "Jane", 
"lastName" : "Smith", "username" : "Jane942", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {'id' : '111', "firstName" : "Andrew", 
"lastName" : "Johnson", "username" : "aJohnson", "hashedPassword" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', 
	data = payload, auth=HTTPBasicAuth(username, password))

payload = {'id' : '222', "firstName" : "Cat", 
"lastName" : "Stevens", "username" : "catWoman", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {'id' : '444', "firstName" : "Dean", 
"lastName" : "Quinn", "username" : "DQ", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))
payload = {'id' : '666', "firstName" : "Edie", 
"lastName" : "Troy", "username" : "eTroy", "hashedPassword" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', 
	data = payload, auth=HTTPBasicAuth(username, password))

payload = {'id' : '777', "firstName" : "Frances", 
"lastName" : "Dream", "username" : "fDears", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {'id' : '888', "firstName" : "Gene", 
"lastName" : "Camper", "username" : "CampOnCamp", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {'id' : '1234', "firstName" : "Heather", 
"lastName" : "Gurn", "username" : "HFeathers", "hashedPassword" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', 
	data = payload, auth=HTTPBasicAuth(username, password))

payload = {'id' : '555', "firstName" : "Ian", 
"lastName" : "Tran", "username" : "iTran", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {'id' : '900', "firstName" : "Kevin", 
"lastName" : "Lester", "username" : "Kles", "password" : "yes", 
"imageURL" : "http:...", "isAdmin" : False}
requests.post('http://mighty-sea-1005.herokuapp.com/addUser', data = payload, 
			auth=HTTPBasicAuth(username, password))

print ("added 12 users")

#New Game
payload = {'id' : '3393', "dayNightFreq" : 1}
requests.post('http://mighty-sea-1005.herokuapp.com/admin/newGame', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("new game started")

#location
payload = {"userID": "3393", 'lat': 41, 'lng':80}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "555", 'lat': 40.45678, 'lng':80.1}
requests.post('http://mighty-sea-1005.herokuapp.com/players/location', data = payload, 
			auth=HTTPBasicAuth(username, password))

payload = {"userID": "942", 'lat': 48, 'lng':82.6789}
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
print("locations updated")

#Players Alive
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/alive', 
			auth=HTTPBasicAuth(username, password))
print("players alive " + r.text)

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
requests.post('http://mighty-sea-1005.herokuapp.com/pla"yers/vote', data = payload, 
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

payload = {"voterID": "777", 'suspectID': "777"}
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

'''
#Players Near
payload = {'player': {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True} , 'daynightFreq' : 12}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("players near " + r.text)

#Kill
payload = {'killer' : {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True}, 
'victim' : {'id' : '456', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "sharon", "isWerewolf" : False}}
requests.post('http://mighty-sea-1005.herokuapp.com/players/kill', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("Kill")

'''
