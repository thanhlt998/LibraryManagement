drop table if exists books;
create table books (
	bookId int primary key auto_increment not null, 
    callNo varchar(100) not null,
    name varchar(100) not null,
    author varchar(100) not null,
    publisher varchar(100) not null,
    quantity int not null,
    issued int not null,
    addedDateTime datetime not null
);

drop table if exists issuebooks;
create table issuebooks (
	issuedBookId int auto_increment not null,
    callNo varchar(100) not null,
    studentId varchar(50) not null,
    studentName varchar(50) not null,
    studentMobile varchar(11) not null,
    issuedDateTime datetime not null,
    returnStatus varchar(3) not null,
    primary key (issuedBookId)
);

drop table if exists librarian;
create table librarian (
	librarianId int primary key not null auto_increment,
    name varchar(30) not null,
    password varchar(30) not null,
    email varchar(30) not null,
    address varchar(30) not null,
    city varchar(30) not null,
    mobile varchar(30) not null
);


INSERT INTO books (bookId, callNo, name, author, publisher, quantity, issued, addedDateTime) VALUES
(1, 'A@4', 'C In Depth', 'Shrivastav', 'BPB', 2, 2, '2016-07-19 19:37:56'),
(2, 'B@1', 'DBMS', 'Korth', 'Pearson', 3, 0, '2016-07-18 18:39:52'),
(3, 'G@12', 'Let''s see', 'Yashwant Kanetkar', 'BPB', 10, 0, '2016-07-18 23:02:14');

INSERT INTO issuebooks (issuedBookId, callNo, studentId, studentName, studentMobile, issuedDateTime, returnStatus) VALUES
(4, 'A@4', 23, 'kk', '932992932', '2016-07-19 18:43:16', 'No'),
(6, 'A@4', 335, 'Sumedh', '95676565756', '2016-07-19 18:44:34', 'No'),
(7, 'A@4', 87, 'abhishek', '9329882382', '2016-07-19 18:46:12', 'No');

INSERT INTO librarian (librarianId, name, password, email, address, city, mobile) VALUES
(1, 'Prabhakar', 'ppp', 'prabhakar@gmail.com', 'javatpoint', 'noida', '9998328238'),
(4, 'sumedh', 'sumesh', 'sumesh@gmail.com', 'Kuch Bhi', 'noida', '93823932823'),
(6, 'abhi', 'abhi', 'abhi@gmail.com', 'javatpoint', 'noida', '92393282323');


drop procedure if exists issueBook;
delimiter $$
create procedure issueBook (
	in _callNo varchar(100),
    in _studentId varchar(50),
    in _studentName varchar(50),
    in _studentMobile varchar(15),
    out flag boolean
)
begin

	declare id int;
	if exists (select books.bookId from books 
			where books.callNo like _callNo 
            and books.quantity > 0 
            limit 1)
    then 
		begin
			select books.bookId into id from books
			where books.callNo like _callNo
			and books.quantity > 0
			limit 1;
			
			insert into issuebooks(callNo, studentId, studentName, studentMobile, issuedDateTime, returnStatus)
			values (_callNo, _studentId, _studentName, _studentMobile, now(), 'No');
			
			update books 
			set books.quantity = books.quantity - 1, books.issued = books.issued + 1
			where books.bookId = id;
			set flag = true;
        end;
	else
		set flag = false;
	end if;
end;

call issueBook('A@4', '20163705', 'Le Tuan Thanh', '12345678', @flag);
select @flag;

drop function if exists issueBook;
delimiter $$
create function issueBook(
	_callNo varchar(100),
    _studentId varchar(100),
    _studentName varchar(50),
    _studentMobile varchar(15)
)
returns boolean
DETERMINISTIC
begin
	declare id int;
    declare flag boolean;
	if exists (select books.bookId from books 
			where books.callNo like _callNo 
            and books.quantity > 0
            limit 1)
    then 
		begin
			select books.bookId into id from books
			where books.callNo like _callNo
			and books.quantity > 0
			limit 1;
			
			insert into issuebooks(callNo, studentId, studentName, studentMobile, issuedDateTime, returnStatus)
			values (_callNo, _studentId, _studentName, _studentMobile, now(), 'No');
			
			update books 
			set books.quantity = books.quantity - 1, books.issued = books.issued + 1
			where books.bookId = id;
			set flag = true;
        end;
	else
		set flag = false;
	end if;
    
    return (flag);
end;

drop function if exists returnBook;
delimiter $$
create function returnBook(
	_callNo varchar(100),
    _studentId varchar(50)
)
returns boolean
deterministic
begin
	declare flag boolean;
    set flag = false;
	if exists(select * from issuebooks
				where callNo like _callNo and studentId like _studentId and returnStatus like 'No'
                limit 1)
	then
		begin
			declare _bookId int;
            declare _issuedBookId int;
            
            select issuedBookId into _issuedBookId from issuebooks
					where callNo like _callNo and studentId like _studentId and returnStatus like 'No'
					limit 1;
                    
			select bookId into _bookId from books
				where callNo like _callNo and issued > 0
                limit 1;
            
			update issuebooks
				set returnStatus = 'Yes'
				where issuedBookId = _issuedBookId;
            
			update books
				set quantity = quantity + 1, issued = issued - 1
				where bookId = _bookId;
			set flag = true;
        end;
	end if;
    
    return (flag);
end;

select returnBook('IT@1', '20163705');