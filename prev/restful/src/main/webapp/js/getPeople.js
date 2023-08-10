console.log('getPeple');

const people_form = document.getElementById('people_form');

people_form.addEventListener('submit',(e) => {
   e.preventDefault();

   // const payload = new URLSearchParams(new FormData(people_form));

   fetch('/people', {
	   method: 'GET',
	   headers: {
		   'Content-Type' : 'application/x-www-form-urlencoded'
	   },
	   // body: decodeURI(payload),
   })
   .then(response => response.json())
   .then(data => console.log(data))
});