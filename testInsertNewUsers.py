############# insert new users to the database #############

import requests
from requests.auth import HTTPBasicAuth

username = "brittany"
password = "yes"

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

payload = {'id' : '900', "firstName" : "Jane", 
"lastName" : "Smith", "username" : "Jane900", "password" : "yes", 
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
