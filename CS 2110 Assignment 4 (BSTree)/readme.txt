Ishtyaq Habib and Omer Syed:
Assignment 4 Problem 2&3 SuperMarketBST

This program is a sandbox for tree manipulation. Main method is in BSTest. 

Features:	 All actors in the supermarket have their own AI. 
			Double-ly Linked list BST
			BST can be displayed either horizontally or vertically
			(Horizontally by default, but can be commented out in toString Method in BSTree Class)
			Displays height of tree
			Balances tree

ReadMe: There are some debug dialogs that pop-up but they should not be too bothersome. 
Our estimate for runtime of balance method is O(n^2). As n elements of the tree are read and stored in a list.
Then that n length list is read and stored in a balanced tree. Resulting in roughly n*n behavior with some coefficents.