# Smart4Aviation

FinalApp is a final solution class, which implements methods:
-DownloadData()
-GetFlightWeight(int flightNumber, String date)
-GetNumberOfFlightsAndBaggage(String IATACode, String date)

GetFlightWeight is the first funcionality. It returns int[], where {cargo_weight, baggage_weight, total_weight}
GetNumberOfFlightsAndBaggage is the second funcionality. It returns int[], where {number_of_departing_flights, number_of_arriving_flights, number_of_baggage_arriving, number_of_baggage_departing}


My assumptions:
-String date argument is in the format "YYYY-MM-dd" for example ("2015-03-16")
-returned weight is in kg. All of the items with weightUnit "lb" are calculated to kg (*0.45359237)
-as we have only departureDate I decided to use it also as a arrivalDate
-for the second funcionality I take data from the whole given day, and as above I assume that arrival date is the same as departue date


To use FinalApp on the beggining data has to be downloaded (the default file path is already set, but it can be changed with setFlightsFilePath() and setCargosFilePath() methods).
DownloadData() downloads data from JSON files and saves it to the class instances on which we are working



I also implemented simple unit tests.



Jakub Szczepanek
