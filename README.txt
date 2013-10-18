Werewolf

Werewolf is a web service that has the functionality to play a modified version of the 
party-game Mafia. This is a multi-player game that has been simplified to two categories 
of people--werewolves & townspeople. The admin is able to set the duration of the 
night/day cycle and the game works off of the players GPS signals,The web service 
is created using Spring and MongoDB.

The test scripts are currently located in the file named test1.py.
There is a testInsertNewUsers.py which will add 12 new distinct users to the game. 
There is a testNewGame.py which will create a new game and create new player objects 
for each of the users that were created. In addition, this script will check that all of the users are
properly created by calling the playersAlive function which will return all of the player objects to the client.

The service is deployed at http://mighty-sea-1005.herokuapp.com