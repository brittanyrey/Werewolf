######## finds players near a wolf and kills one ########

import requests
from urllib import urlencode
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

#Players Near
payload = {'userID' : '3393'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/findAllNear', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 3393---players near " + r.text)

'''
payload = {'userID' : '555'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 555---players near " + r.text)

payload = {'userID' : '942'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 942---players near " + r.text)

payload = {'userID' : '111'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 111---players near " + r.text)

payload = {'userID' : '222'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 222---players near " + r.text)

payload = {'userID' : '444'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 444---players near " + r.text)

payload = {'userID' : '666'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 666---players near " + r.text)

payload = {'userID' : '777'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 777---players near " + r.text)

payload = {'userID' : '888'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 888---players near " + r.text)

payload = {'userID' : '1234'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', 
	data = payload, auth=HTTPBasicAuth(username, password))
print("User ID: 1234---players near " + r.text)

payload = {'userID' : '555'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 555---players near " + r.text)

payload = {'userID' : '900'}
r = requests.get('http://mighty-sea-1005.herokuapp.com/players/near', data = payload, 
			auth=HTTPBasicAuth(username, password))
print("User ID: 900---players near " + r.text)
'''
