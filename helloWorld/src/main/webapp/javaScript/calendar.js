var today=new Date();
console.log(today);
console.log(today.getFullYear());
console.log(today.getMonth());
console.log(today.getDate());
console.log(today.getDay());

//document.write(`<h3>${today.getFullYear()}년 ${today.getMonth()+1}월</h3>`);
//var lastDay=new Date(2022,12,0);



for(var m=0;m<12;m++){
    var lastDay=new Date(2022,m,0);
    var dDay=new Date(2022,m+1,0);
    document.write(`<h3>${today.getFullYear()}년 ${m+1}월</h3>`);
    var lastDay2=(lastDay.getDay());
  

        
        for(var n=0;n<=lastDay2;n++){
            document.write('<span>*</span>');
            if(n==6){
                document.write('<br>');
            }
        }

        for(var i=1;i<=(dDay).getDate();i++){
            
            document.write('<span>'+i+'</span>');
            if((i+(lastDay2+1))%7==0){
                document.write('<br>');
            }

        }
       
         document.write('<br>');
}
