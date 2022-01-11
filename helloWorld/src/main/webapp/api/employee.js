const titles = ['empID', 'fName','lname','E-mail', 'hireDate','Job','Salary'];
const fields = ['employeeId','firstName','lastName','email','hireDate','jobId','salary'];
function makeHead() {
    
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    //체크박스
    let th = document.createElement('th');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    checkbox.addEventListener('change', allCheckFnc);
    th.appendChild(checkbox);
    tr.appendChild(th);
    //필드영역
    titles.forEach(function (field) {
        let th = document.createElement('th');
        let text = document.createTextNode(field);
        th.appendChild(text);
        tr.appendChild(th);
    });

   thead.appendChild(tr);
    return thead;
}

function allCheckFnc() {
    console.log(this.checked);
    let chks = document.querySelectorAll('tbody input[type="checkbox"]');
    for (var i = 0; i < chks.length; i++) {
        chks[i].checkbox = this.checked;
    }
}


//tbody
function makeBody(data) {
    let tbody = document.createElement('tbody');
    data.forEach(function (data) {

        tbody.appendChild(makeTr(data));
    });
    return tbody;
}
//tr생성
function makeTr(data) {
    let tr = document.createElement('tr');
    //체크박스
    let td = document.createElement('td');

    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    td.appendChild(checkbox);
    tr.appendChild(td);
    //데이터영역
    for (let field of fields) {
        let td = document.createElement('td');
        let text = document.createTextNode(data[field]);
       // console.log(text);
        td.appendChild(text);
        tr.appendChild(td);
    }
    return tr;
}
//실행
(function (){
	//ajax
	 let xhtp=new XMLHttpRequest();
        xhtp.onreadystatechange = function(){
            if(xhtp.readyState==4 && xhtp.status ==200){
            console.log('readystate: '+xhtp.readyState);
            console.log('status:'+xhtp.status);
            let data=JSON.parse(xhtp.responseText);
            console.log(data);

			let table = document.createElement('table');
			table.setAttribute('border', '1');
			table.appendChild(makeHead());
			table.appendChild(makeBody(data));
			document.getElementById('list').appendChild(table);
			
			//console.log(table);	

            //makePage(data);
            //showCenterList(data);
        }
        }
        xhtp.open('get','../EmpList.json');
        xhtp.send();

}());

let addBtn=document.querySelector('#btn>button');
let eid=document.querySelector('input[name="eid"]').value;
	console.log(eid);
console.log(addBtn);
addBtn.addEventListener('click',addCallback);
function addCallback(){
	let eid=document.querySelector('input[name="eid"]').value;
	console.log(eid);
    let fname=document.querySelector('input[name="fname"]').value;
	let lname=document.querySelector('input[name="lname"]').value;
	let hireDate=document.querySelector('input[name="hire_date"]').value;
    let email=document.querySelector('input[name="email"]').value;
    let salary=document.querySelector('input[name="salary"]').value;
    if(eid==""||lname==""||hireDate==""||email==""){
        window.alert('필수 값을 입력하세요.');
        return;
    }

	let xhtp=new XMLHttpRequest();
	
	xhtp.onload = function(){
	let result=	JSON.parse(xhtp.responseText);
	console.log(result);
	let tr=makeTr(result);
    document.querySelector('#list>table>tbody').appendChild(tr);
	}
	
	xhtp.open('post','../InsertEmployeeServlet');
	xhtp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
	xhtp.send(`employee_id=${eid}&first_name=${fname}&last_name=${lname}&hire_date=${hireDate}&email=${email}&salary=${salary}&job_id="IT_PROG"`);
	
   /* let obj={
        name:name,
        phone:phone,
        addr:addr,
        email:email
    }
    */
}
let delBtn=document.querySelector('#btn>button:nth-child(2)');

delBtn.addEventListener('click',delCallback);
function delCallback(){
    let chks=document.querySelectorAll('tbody input[type="checkbox"]');
    for(let i=0;i<chks.length;i++){
        
        if(chks[i].checked==true){
			console.log(chks[i].parentNode.nextSibling.innerText);
			let del_id =chks[i].parentNode.nextSibling.innerText;
			
           //ajax 호출
			const xhtp=new XMLHttpRequest();
			
			xhtp.onload=function(){
			console.log(xhtp.responseText);
			let result=JSON.parse(xhtp.responseText);
			if(result.retCode == 'Success'){
				chks[i].parentNode.parentNode.remove();
			}else{
				window.alert("no")
			}
				
			}
			
			xhtp.open('post','../DeleteEmployeeServlet');
			xhtp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
			xhtp.send(`emp_id=${del_id}`);
            
        }
    }
}
let names=document.querySelectorAll('table tbody tr td:nth-child(2)');

for(let i = 0;i<names.length;i++){
    names[i].addEventListener('click',showInfo);
}
function showInfo(){
    let parent=names[0].parentNode;
    console.log(parent.childNodes[2].innerText);
    document.querySelector('input[name="phone"]').value
    =parent.childNodes[2].innerText;
    };
//---------------------------------------------


