let datas=`[{"id":1,"first_name":"Berton","last_name":"McOnie","email":"bmconie0@skyrock.com","gender":"Female","ip_address":"197.19.127.121"},
{"id":2,"first_name":"Onida","last_name":"Hubert","email":"ohubert1@ucoz.com","gender":"Female","ip_address":"17.140.143.102"},
{"id":3,"first_name":"Fiorenze","last_name":"Evelyn","email":"fevelyn2@businessinsider.com","gender":"Male","ip_address":"55.81.31.33"},
{"id":4,"first_name":"Sergio","last_name":"Mager","email":"smager3@uiuc.edu","gender":"Male","ip_address":"103.102.168.137"},
{"id":5,"first_name":"Sherill","last_name":"O'Rowane","email":"sorowane4@jimdo.com","gender":"Female","ip_address":"206.1.125.26"},
{"id":6,"first_name":"Dyane","last_name":"Gauch","email":"dgauch5@cbc.ca","gender":"Female","ip_address":"242.93.106.79"},
{"id":7,"first_name":"Farleigh","last_name":"Pessolt","email":"fpessolt6@parallels.com","gender":"Female","ip_address":"136.137.3.8"},
{"id":8,"first_name":"Verna","last_name":"Brownbill","email":"vbrownbill7@disqus.com","gender":"Male","ip_address":"52.245.158.73"},
{"id":9,"first_name":"Lorene","last_name":"Aicheson","email":"laicheson8@google.fr","gender":"Male","ip_address":"234.19.213.79"},
{"id":10,"first_name":"Tandy","last_name":"Chicken","email":"tchicken9@kickstarter.com","gender":"Female","ip_address":"32.157.228.2"},
{"id":11,"first_name":"Idell","last_name":"Creser","email":"icresera@jimdo.com","gender":"Male","ip_address":"235.88.90.77"},
{"id":12,"first_name":"Lauralee","last_name":"Kiggel","email":"lkiggelb@ucsd.edu","gender":"Male","ip_address":"20.66.105.57"},
{"id":13,"first_name":"Lane","last_name":"Scarff","email":"lscarffc@columbia.edu","gender":"Male","ip_address":"38.169.235.209"},
{"id":14,"first_name":"Ninnette","last_name":"Spinley","email":"nspinleyd@taobao.com","gender":"Female","ip_address":"76.84.91.150"},
{"id":15,"first_name":"Gillie","last_name":"Lundie","email":"glundiee@google.nl","gender":"Female","ip_address":"81.25.198.227"}]`;
let employees=JSON.parse(datas);
console.log(employees);
document.write('<table border="1">');
document.write('<thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Gender</th></tr></thead>')
document.write('<tbody>');
employees.forEach(function(item,idx){
    document.write('<tr>');
    document.write(`<td>${item.id}</td>`);
    document.write(`<td>${item.first_name} ${item.last_name}</td>`);
    document.write(`<td>${item.email}</td>`);
    document.write(`<td>${item.gender}</td>`);
    document.write('</tr>');
});
document.write('<tbody>');
document.write('</table>');
let firstNames=[];
employees.forEach(namesFnc);

function namesFnc(item){
    //console.log(item.first_name);
   firstNames.push(item.first_name);
}
console.log(firstNames);