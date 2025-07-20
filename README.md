# AutoShelf
An efficient autocomplete system that provides real-time search suggestions for book titles using the Trie data structure. It handles both popular (hot) and classic (cold) book datasets.

Features:
Autocomplete Suggestions: Provides search suggestions based on a typed prefix.
Hot vs Cold Data: Separately handles frequently accessed (hot) and less accessed (cold) books.
Multithreading Support: Loads hot and cold data files concurrently using threads.
Trie-Based Storage: Stores data efficiently and performs fast prefix searches.
File-Based Loading: Book data is read from external .txt files.
Graceful CLI Interaction: Users can interact via command-line interface by typing prefixes or exiting.


Technologies / Concepts Used:

Java
Data Structures (Trie)
Multithreading
File I/O
Collections (HashMap, List)
OOP Concepts