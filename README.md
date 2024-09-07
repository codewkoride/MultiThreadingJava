# MultiThreadingJava
Program to demonstrate the usage of Threads and Synchronized block in Java

PROBLEM STATEMENT
Goal:	In	this	project	you	will	complete	several	classes	to	find	the	maximum	Integer	
in	a LinkedList	in	parallel.	These	classes	should	be	thread	safe.

• Class	ParallelMaximizer,	method	max
Note:	Since	this	method	invokes	several	ParallelMaximizerWorkers,	it	is	
expected	to	be	thread	safe.	The	method	runs	numThread	number of	
threads	and	then	joins	them.	You	are responsible	for	computing	the	
partial	maximum	from	these	results	by	calling	getPartialMax()	from	each	
ParallelMaximizerWorker.	
• You	need	to	modify	main:
o (1)	you	need	to	set	the	size	of	list	to	10,000,000	and	run	2,000	
ParallelMaximizerWorker	objects.	
• Class	ParallelMaximizerWorker,	method	run
Note:	This	method	should	find	the	maximum	for	all	integers	processed	by	
this	worker,	which	can	be	combined	to	find	the	overall	maximum.	If	the	list	is	
not	empty,	the	function	synchronizes	on	it	to	prevent	access	by	other	threads	
and	removes	the	head	node,	storing	its	value	in	the	variable	number.	You	are	
responsible	for	taking	this	value	and	evaluating	the	new	partial	maximum.	


