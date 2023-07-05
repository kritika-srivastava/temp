let movieList = [];
let favMovieList = [];


function displayMovies(movies) {
	let moviesList = document.getElementById('moviesList');

	let htmlcode = "";
	movies.forEach(movie => {
		htmlcode += `
		<div class="card mb-3" style="width: 90%; background-color: #97caef;">
  <div class="row no-gutters">
  
    <div class="col-md-4">
      <img src="${movie.posterPath}" class="card-img" alt="...">
	 
    </div>
    <div class="col-md-8">
	<a href="#" class="btn" style="display:block;float:right;" onclick='addFavourite(${movie.id})'>
	<i class="fa fa-heart text-success"></i></a>
      <div class="card-body">
        <h5 class="card-title"> ID - ${movie.id}</h5>
		
        <p class="card-text">Title - ${movie.title}</p>
        <p class="card-text">
		<small class="text-muted">Runtime - ${movie.runtime} minutes</small></p>
      </div>
    </div>
  </div>
</div>
		`
	});

	moviesList.innerHTML = htmlcode;
}


function displayFavourites(movies) {
	let favouriteMoviesList = document.getElementById("favouritesList");
	let htmlcode = "";
	movies.forEach(movie => {
		htmlcode += `
		<div class="card mb-3" style="width: 90%; background-color: #97caef;">
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src="${movie.posterPath}" class="card-img" alt="...">
    </div>
    <div class="col-md-8">
	<a href="#" class="btn" style="display:block;float:right;">
	<i class="fa fa-trash" style="color:red">
	</i></a>
      <div class="card-body">
        <h5 class="card-title"> ID - ${movie.id}</h5>
        <p class="card-text">Title - ${movie.title}</p>
        <p class="card-text">
		<small class="text-muted">Runtime - ${movie.runtime} minutes</small>
		</p>
      </div>
    </div>
  </div>
</div>
		`
	});

	favouriteMoviesList.innerHTML = htmlcode;
}

function getMovies() {
	return fetch('http://localhost:3000/movies').then(response => {
		return response.json();
	}).then(movies => {
		movieList = movies;
		displayMovies(movieList);
		return movies;
		//	console.log(movies);

	}).catch(error => {
		return Promise.reject(new Error(error));
	});

}

function getFavourites() {

	return fetch('http://localhost:3000/favourites').then(response => {
		return response.json();
	}).then(movies => {
		favMovieList = movies;
		//	console.log(movies);
		displayFavourites(favMovieList);
		return movies;

	}).catch(error => {
		return Promise.reject(new Error(error));
	});
}

function addFavourite(id) {
	//	console.log(favMovieList);
	let fav = movieList.find(movie => {
		if (movie.id === id) {
			return movie;
		}
	});
	let favTrue = favMovieList.find(favourite => {
		if (favourite.id === fav.id) {
			return favourite;
		}
	});
	console.log(favTrue);
	if (favTrue) {

		return Promise.reject(new Error('Movie is already added to favourites'));
	}
	else {
		return fetch(`http://localhost:3000/favourites`, {
			method: 'POST',
			headers: {
				'content-type': 'application/json'
			},
			body: JSON.stringify(fav)
		}
		).then(response => {
			if (response.ok) {
				return response.json();
			}
			return;
		}
		).then(addedMovie => {
			favMovieList.push(addedMovie);
			displayFavourites(favMovieList);
			// console.log(favMovieList);
			return favMovieList;
		}
		);
	}
}


module.exports = {
	getMovies,
	getFavourites,
	addFavourite
};

// You will get error - Uncaught ReferenceError: module is not defined
// while running this script on browser which you shall ignore
// as this is required for testing purposes and shall not hinder
// it's normal execution


