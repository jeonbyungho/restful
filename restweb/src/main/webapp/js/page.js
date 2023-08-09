// const url = 'https://codingapple1.github.io/price.json';

window.onload = () => {

   let pathname = location.pathname;
   let index = pathname.lastIndexOf('/');
   let sub = pathname.substring(index + 1);

   const url = 'http://localhost:8080/people/info/' + sub;

   console.log('📢GET Request', url);

   fetch(url)
   .then(resp => {
      if (!resp.ok) {
         throw new Error('🤮 에러 응답을 받았습니다.');
      }
      return resp.json();
   })
   .then(json => {
      console.log(json);
   })
   .catch( (e) => {
      console.error(e.error);
   })
}