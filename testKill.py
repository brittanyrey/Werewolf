######## finds players near a wolf and kills one ########

import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

#Players Near
payload = {'userID' : '3393'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 3393---players near " + r.text)

payload = {'userID' : '555'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 555---players near " + r.text)

payload = {'userID' : '942'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 942---players near " + r.text)

payload = {'userID' : '111'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 111---players near " + r.text)

payload = {'userID' : '222'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 222---players near " + r.text)

payload = {'userID' : '444'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 444---players near " + r.text)

payload = {'userID' : '666'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 666---players near " + r.text)

payload = {'userID' : '777'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 777---players near " + r.text)

payload = {'userID' : '888'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 888---players near " + r.text)

payload = {'userID' : '1234'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 1234---players near " + r.text)

payload = {'userID' : '555'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 555---players near " + r.text)

payload = {'userID' : '900'}
requests.post('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 900---players near " + r.text)

