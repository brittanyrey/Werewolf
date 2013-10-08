import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

#Home Page
r = requests.get('http://localhost:8080/werewolf/', 
			auth=HTTPBasicAuth(username, password))
print(r.text)

#New Game
payload = {'player': {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True} , 'daynightFreq' : 1}
#requests.post('http://localhost:8080/werewolf/admin/newGame', data = payload)
print("new game started")

#Players Alive
r = requests.get('http://localhost:8080/werewolf/players/alive', 
			auth=HTTPBasicAuth(username, password))
print("players alive " + r.text)

#Players Near
payload = {'player': {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True} , 'daynightFreq' : 12}
r = requests.get('http://localhost:8080/werewolf/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("players near " + r.text)

#Kill
payload = {'killer' : {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True}, 
'victim' : {'id' : '456', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "sharon", "isWerewolf" : False}}
requests.post('http://localhost:8080/werewolf/players/kill', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("Kill")

#location
payload = {'location' : {'latitude': 40, 'longitude':80}}
requests.post('http://localhost:8080/werewolf/location', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("location")

#Vote
payload = {'player' : {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True}, 
'votee' : {'id' : '456', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "sharon", "isWerewolf" : False}}
requests.post('http://localhost:8080/werewolf/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("Vote cast")
