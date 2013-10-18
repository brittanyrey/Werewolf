######## create New Game and ensure all Player objects were created ########

import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

#New Game
payload = {'id' : '3393', "dayNightFreq" : 1}
requests.post('http://mighty-sea-1005.herokuapp.com/admin/newGame', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("new game started")


#Players Alive
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/alive', 
			auth=HTTPBasicAuth(username, password))
print("players alive " + r.text)
