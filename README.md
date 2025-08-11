# Laboratory---GUI-application
Using the Java programming language, I created an application that is connected to the database and enables working with tables about patients, findings and searches.

The application deals with the organization of patients, findings and examinations within one laboratory. Patients come for examinations where they can make findings. One patient can perform several tests. Since the finding has a date, it is possible to track how often and when each finding was made. One finding belongs to exactly one patient, so the table finding has the key of the patient to which it belongs. This is a typical example of a 1:N relationship where the patient participates multiple times in the relationship, and the finding only once. Multiple searches can be found within one search. For the sake of transparency, the maximum number of searches for one finding is 3. One search is not unique to only one finding, so it can also be in several findings. For this reason this is an N:M relationship. 
We collect all data from users and save them in one database. The database is made in SQLite and throughout the application we use SQL commands to access our database. The application offers about 15 options over the 3 entities I work with. Each entity can be added, updated, deleted and searched. In this way, we give flexibility to the user and the possibility of processing all actions on each entity. The goal is to facilitate the storage of all data in a laboratory.
This type of application helps in all companies that deal with the processing of several hundreds or thousands of information. Every action performed is immediately saved and the action is taken in a specific database.
We work with the correct entered data that is already there, which makes it possible for every search to come up with only those data that have survived in the database or come with their new changed values.

ER MODEL

<img width="913" height="657" alt="image" src="https://github.com/user-attachments/assets/82d8744d-e2f3-4b21-b01b-01b3ce6236f7" />

ADMIN LOGIN

<img width="658" height="430" alt="image" src="https://github.com/user-attachments/assets/9c2d4dc3-2496-4f97-a1f4-bc52c7bd4d4e" />

MAIN WINDOW

<img width="1048" height="341" alt="image" src="https://github.com/user-attachments/assets/8c2684ff-071d-4a2d-b941-d21642d90763" />

<img width="655" height="297" alt="image" src="https://github.com/user-attachments/assets/a983460b-8e6a-49a6-9a8e-d5f73b7786c7" />

Below you will see the layout of each window along with the buttons and functionalities offered.

Adding a new patient

<img width="597" height="469" alt="image" src="https://github.com/user-attachments/assets/d8c9ec6d-2f18-49ae-975d-4c00a1cca4c4" />

Patient search along with other functionalities (updating, printing all findings and adding findings)

<img width="767" height="491" alt="image" src="https://github.com/user-attachments/assets/392e7f33-aab7-43fb-9eda-4ee1df4d76e6" />

Adding findings from the patient search window

<img width="470" height="385" alt="image" src="https://github.com/user-attachments/assets/370f9bb4-46aa-4b4f-9d32-9936a14cb68b" />

Overview of all findings for a specific patient

<img width="840" height="412" alt="image" src="https://github.com/user-attachments/assets/20a47514-4150-46b4-8752-1bf61e416ff0" />

This window offers the possibility to view all searches related to a specific finding, which we select by clicking on it. The overview of searches related to a finding looks like this:

<img width="500" height="370" alt="image" src="https://github.com/user-attachments/assets/64503f36-7461-4bc9-a659-900154e0d09d" />

Data entry in the findings table if it is selected on the menu that you want to enter the findings independently without prior examination of the patient. The difference is that then we don't have to enter the patient ID. In contrast to this entry, when we enter the finding after searching the patient, the ID of the searched patient immediately appears in this form for adding a new finding, thus reducing the error that the application user enters the wrong ID.

<img width="518" height="425" alt="image" src="https://github.com/user-attachments/assets/be4f9078-e9f6-4984-8f2a-9cac7324195f" />

Print all findings with the same name

<img width="670" height="331" alt="image" src="https://github.com/user-attachments/assets/acb1800d-f30c-4d5b-8ebd-81811ddbc7e7" />

The options related to the previous window are update and print searches. If we want to enter a new state, it is enough to double-click on the cell whose content we want to replace and enter the new text. By clicking on the update button, the new state will be saved. Printing findings works as in the previous section where we could select a finding and then its searches are printed. This is the window that appears when we only want to search the findings.

Enter a new search

<img width="450" height="332" alt="image" src="https://github.com/user-attachments/assets/cfc481e5-e67e-47a0-96bf-dc0d3f68a3d7" />

Search search

<img width="761" height="475" alt="image" src="https://github.com/user-attachments/assets/1c717f3e-b5f8-401e-b72a-0ab0d5cdd596" />

Linking searches to findings

<img width="945" height="589" alt="image" src="https://github.com/user-attachments/assets/51f2bd3a-4183-4ba1-a262-01b3dd0c9081" />

In the upper part, the ID of the finding to which the entered searches are linked is entered. After that, 1, 2 or a maximum of 3 searches can be selected and, depending on the number of selected searches, the measured values for the performed searches are entered from the table. After clicking the add button, the Finding is entered into the database with each of the selected searches and the measured values.
If we enter the finding first, this window automatically appears so that the field with the ID is filled with the finding that was entered at that time.





