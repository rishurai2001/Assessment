#include <iostream>
#include "sqlite3.h"
using namespace std;

static int callback(void* data, int argc, char** argv, char** azColName)
{
	int i;
	fprintf(stderr, "%s: ", (const char*)data);

	for (i = 0; i < argc; i++) {
		printf("%s = %s\n", azColName[i], argv[i] ? argv[i] : "NULL");
	}

	cout<<"\n";
	return 0;
}

int main(int argc, char** argv)
{
    sqlite3* DB;
	string sql = "CREATE TABLE STUDENT("
					"ROLLNO INT PRIMARY KEY	 NOT NULL, "
					"NAME		 TEXT NOT NULL, "
                    "MATHS		 INT, "
                    "SCIENCE        INT, "
                    "SOCIAL	      INT,"
                    "ENGLISH  INT, ,
                    "HINDI INT");";
	int exit = 0;
	exit = sqlite3_open("Test.db", &DB);
	char* messaggeError;
	exit = sqlite3_exec(DB, sql.c_str(), NULL, 0, &messaggeError);

	if (exit != SQLITE_OK) {
		cerr << "Error Create Table" << std::endl;
		sqlite3_free(messaggeError);
	}
	else
		std::cout << "Table created Successfully" << std::endl;

	string query = "SELECT * FROM STUDENT;";

	cout << "Table Before Insert" << endl;

	sqlite3_exec(DB, query.c_str(), callback, NULL, NULL);


    // Insertion fo Record 
	sql = "INSERT INTO STUDENT VALUES(1, 'RISHU', 66, 30, 100,90,34);"
			"INSERT INTO STUDENT VALUES(2, 'VIKAS', 45, 76,89,80, 32);"
			"INSERT INTO STUDENT VALUES(3, 'PRIYA', 56,78,89, 27, 99);";
      "INSERT INTO STUDENT VALUES(3, 'ANKIT', 66,98,99, 84, 79);"

	exit = sqlite3_exec(DB, sql.c_str(), NULL, 0, &messaggeError);
	if (exit != SQLITE_OK) {
		std::cerr << "Error Insert" << std::endl;
		sqlite3_free(messaggeError);
	}
	else
		std::cout << "Records created Successfully!" << std::endl;

	cout << "Table after insertion" << endl;

	sqlite3_exec(DB, query.c_str(), callback, NULL, NULL);

	
	// Deletion of Record
	sql = "DELETE FROM STUDENT WHERE ROLLNO = 2;";
	exit = sqlite3_exec(DB, sql.c_str(), NULL, 0, &messaggeError);
	if (exit != SQLITE_OK) {
		cerr << "Error DELETE" << endl;
		sqlite3_free(messaggeError);
	}
	else
		cout << "Record deleted Successfully!" <<endl;

	cout << "STATE OF TABLE AFTER DELETE OF ELEMENT" << endl;
	sqlite3_exec(DB, query.c_str(), callback, NULL, NULL);
	
	
	//Updation of Record
	sql = "UPDATE STUDENT set MATHS = 35 where ROLLNO=2;";
   
        exit = sqlite3_exec(DB, sql.c_str(), NULL, 0, &messaggeError);
	if (exit != SQLITE_OK) {
		std::cerr << "Error Update" << std::endl;
		sqlite3_free(messaggeError);
	}
	else
		std::cout << "Records Updated Successfully!" << std::endl;
	
	cout << "STATE OF TABLE AFTER UPDATE" << endl;

	sqlite3_exec(DB, query.c_str(), callback, NULL, NULL);
	
	

	sqlite3_close(DB);
	return (0);
}
