# Object Orientation with Design Patterns CA 1

Student: Jennifer Magpantay ID 2017325

Lecture: Amilcar Aponte - CCT College Dublin

As part of our practical exercises, the students were asked to create a simple program following Object Orientation with Design Patterns principles, where would be possible for a user access a database to search through it and even add a new element to it.

Three different patterns should be implemented in the program, considering DAO as a mandatory pattern. The other two patterns, both creative patterns, were free of choice for the students.

For this practical work I have implemented:
DAO (as mandatory, but free of choice where to use it) on the Country, interface CountryDAO and CountryDAOImpl. This was made to separate the user, aplication and data layers from each other and to avoid the user to access directly the database access mechanism. All methods to access and use the database is made through the Country classes.

Singleton is used (as default) on the enum Continent class, and also was implemented on the Database class. This is to ensure that there is only one instance of the class in the entire program. For other class to access the class, they must be call its instance through the getInstance() method, instead of doing this directly.

Builder on the Country and CountryAbs classes. Considering that a new object of the Country class has to be made as one of the option is given to the users when they are accessing the program, the builder pattern helps to create a instance of this complex step by step creatin process, giving a order and a list of specific elements (variales) this new object has to have.
