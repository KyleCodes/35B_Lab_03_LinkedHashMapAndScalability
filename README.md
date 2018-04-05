# 35B_Lab_03_LinkedHashMapAndScalability
This update is intended to increase efficiency given the fact that the database could scale to hundreds of thousands of models. All arrays in the model package are replaced with ArrayLists, and a static linked hash map is instantiated in the adapter package to hold the database, and be accessed by the the current and future interfaces
