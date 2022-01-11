var memNum=window.prompt('입장객은 몇명입니까?');
var colNum=window.prompt('한줄에 앉을 사람?');
var cnt=0;
var rowNum = Math.ceil(memNum/colNum);

for(var i=1;i<=memNum;i++){
   for(var j=1;j<=colNum;j++){
        document.write(`<span>좌석${i}-${j}</span>`);
        cnt++;
        if(cnt==memNum){
            break;
    }
   }
    document.write('<br>');
}