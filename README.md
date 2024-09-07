# MultiThreadingJava
Program to demonstrate the usage of Threads and Synchronized block in Java

PROBLEM STATEMENT
Goal:	In	this	project	you	will	complete	several	classes	to	find	the	maximum	Integer	
in	a LinkedList	in	parallel.	These	classes	should	be	thread	safe.
Code	to	implement:	In	the	starter	files,	the	methods	to	implement	have	the	
comment	//	TODO:	IMPLEMENT	CODE	HERE	within	them.	The	Javadoc	explains	
what	these	methods	should	do	(which	you	can	compare	against	the	public	test).	
Public	tests	are	in	the	file	PublicTest.java. They	are	in	Course	Documents	/	Code		/
HW 1 Code
• Class	ParallelMaximizer,	method	max
Note:	Since	this	method	invokes	several	ParallelMaximizerWorkers,	it	is	
expected	to	be	thread	safe.	The	method	runs	numThread	number of	
threads	and	then	joins	them.	You	are responsible	for	computing	the	
partial	maximum	from	these	results	by	calling	getPartialMax()	from	each	
ParallelMaximizerWorker.	
• The	starter	files	have	been	developed	for	a	little	different	task;	just	to	compute	a	
max	in	parallel.	But	in	this	assignment,	you	need	to	modify	main:
o (1)	you	need	to	set	the	size	of	list	to	10,000,000	and	run	2,000	
ParallelMaximizerWorker	objects.	
o (2)	The	computation	of	the	max	must	be done	in	two	steps.	First,	all	the	
workers	compute	their	local	max of	the	ints	in	list and	then	store	them	in	
another	list	(list2)	on	which	you	will	invoke	numWorker2 ==	100 of	
ParallelMaximizerWorker	in	order	to	compute	only	numWorker2	local	
max	results,	which	will	then	be	passed	to	a	sequential	computation	of	the	
ultimate	max.	
• Class	ParallelMaximizerWorker,	method	run
Note:	This	method	should	find	the	maximum	for	all	integers	processed	by	
this	worker,	which	can	be	combined	to	find	the	overall	maximum.	If	the	list	is	
not	empty,	the	function	synchronizes	on	it	to	prevent	access	by	other	threads	
and	removes	the	head	node,	storing	its	value	in	the	variable	number.	You	are	
responsible	for	taking	this	value	and	evaluating	the	new	partial	maximum.	
