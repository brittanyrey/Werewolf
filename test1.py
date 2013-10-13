import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

#Home Page
r = requests.get('http://mighty-sea-1005.herokuapp.com/', 
			auth=HTTPBasicAuth(username, password))
print(r.text)

#New Game
payload = {'player': {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True} , 'daynightFreq' : 1}
requests.post('http://mighty-sea-1005.herokuapp.com/admin/newGame', data = payload)
print("new game started")
'''
#Players Alive
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/alive', 
			auth=HTTPBasicAuth(username, password))
print("players alive " + r.text)

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

#location
payload = {'location' : {'latitude': 40, 'longitude':80}}
requests.post('http://mighty-sea-1005.herokuapp.com/location', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("location")

#Vote
payload = {'player' : {'id' : '123', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "brittany", "isWerewolf" : True}, 
'votee' : {'id' : '456', "isDead" : False, "lat" : 30, "lng" : 95, 
"userID" : "sharon", "isWerewolf" : False}}
requests.post('http://mighty-sea-1005.herokuapp.com/players/vote', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("Vote cast")'''
