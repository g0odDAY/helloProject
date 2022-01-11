var num=prompt('점수를 입력하세요:');
var grade='';
if(num>90){
    grade='A';
}else if(num>80){
    grade = 'B';

}else if(num>70){
    grade='C';
}else{
    grade='D';
}
document.write(`점수는 : ${num}이고 등급은 ${grade}입니다.`);
