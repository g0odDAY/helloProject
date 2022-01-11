let sum=function(first,last){
    return first+last;
}
let anotherSum=sum;

console.log(sum(10,20));
console.log(anotherSum(30,40));
let getMinVal= (first,last) => first > last ? last:first;
  

console.log(getMinVal(10,5));