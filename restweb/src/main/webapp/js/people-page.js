// const url = 'https://codingapple1.github.io/price.json';
const url = 'http://localhost:8080/people/info/1';

async function getRequset(){
   const response = await fetch(url);
   if(!response.ok){
      throw new Error('400 또는 500 Error');
   }
   
   response.json().then( (json) => {
      console.log(json);
   });
}

getRequset();