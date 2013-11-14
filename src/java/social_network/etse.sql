SELECT distinct Doctor.login FROM Doctor LEFT JOIN Specialisation ON Doctor.login=Specialisation.login
Left JOIN Address ON Address.login=Doctor.login WHERE first_name LIKE "%Bob%";
