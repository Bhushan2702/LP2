% Define rules for airline scheduling and cargo schedules
airline_scheduling(Airline, Action) :-
    airline_status(Airline, Status),
    action_for_airline(Status, Action).

airline_status('Emirates', 'Emirates Airline').
airline_status('Lufthansa', 'Lufthansa Airline').
airline_status('Singapore', 'Singapore Airlines').
airline_status('IndiGo', 'IndiGo Airlines').

action_for_airline('Emirates Airline', 'Schedule Flight') :-
    write('Do you want to schedule a flight with Emirates? (yes/no)'),
    read(Response),
    Response = 'yes'.

action_for_airline('Lufthansa Airline', 'Cargo Booking') :-
    write('Do you want to book cargo with Lufthansa? (yes/no)'),
    read(Response),
    Response = 'yes'.

action_for_airline('Singapore', 'Cancel Flight') :-
    write('Do you want to cancel a flight with Singapore Airlines? (yes/no)'),
    read(Response),
    Response = 'yes'.

action_for_airline('IndiGo Airline','Book Flight'):-
    write('Do you want book the flight(yes/no)?'),
    read(Response),
    Response = 'yes'.
