/**
 * Created by dido on 11/3/14.
 */

// Create a module for our core AMail services
var vitaBoxServices = angular.module('VitaBOX', ['ngRoute', 'ui.bootstrap']);

// Creating filter for checking if the url is trusted
vitaBoxServices.filter('trusted', ['$sce', function ($sce) {
    return function(url) {
        return $sce.trustAsResourceUrl(url);
    };
}]);

// Set up our mappings between URLs, templates, and controllers
function vitaboxRouteConfig($routeProvider) {
    $routeProvider.when('/', {
        controller: HomeController,
        templateUrl: '/home.html'
    }).when('/movies/:category', {
        controller: MovieController,
        templateUrl: '/movies/movies.html'
    }).when('/movies/movieDetail/:id', {
        controller: MovieDetailController,
        templateUrl: '/movies/movieDetail.html'
    }).when('/movies/movieTrailer/:trailerURL', {
        controller: movieTrailerController,
        templateUrl: '/movies/movieTrailer.html'
    }).when('/movies/FindSubs/:id', {
        controller: playMovieController,
        templateUrl: '/movies/moviePlayerTest.html'
    }).when('/movies/movieInfo/:id', {
        controller: playMovieController,
        templateUrl: '/movies/moviePlayerTest.html'
    }).when('/player/playMovie', { // Player Controller
        controller: moviePlayerController,
        templateUrl: '/player/player.html'
    }).when('/music/:category', { //------------------Add nslavov--------------
        controller: RadioController,
        templateUrl: '/music/music.html'
    }).otherwise({
        redirectTo: '/'
    });
}
//Http provider config
function httpProviderConfig($httpProvider) {
    console.log("AD");
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}

function sceProviderConfig($sceDelegateProvider) {
    $sceDelegateProvider.resourceUrlWhitelist(['^(?:http(?:s)?:\/\/)?(?:[^\.]+\.)?\(vimeo|youtube)\.com(/.*)?$', 'self', 'http://192.168.6.10/**']);

}



// Bind config
vitaBoxServices.config(vitaboxRouteConfig);
vitaBoxServices.config(httpProviderConfig);
vitaBoxServices.config(sceProviderConfig);

function HomeController($scope) {
    document.getElementById("allMovies").style.display = "none";
    document.getElementById("allRadio").style.display = "none"
    document.getElementById("mainNav").style.display = "block";
    document.getElementById("vitabox-category").innerHTML = "Home";
}

/**
 * Movie Detail controller
 * @param $scope
 * @param $http
 * @param $routeParams
 * @constructor
 */
function MovieDetailController($scope, $http, $routeParams, $rootScope) {
    var movieId = $routeParams.id;
    var category = $rootScope.movieCategory;
    $rootScope.tmdbId = $routeParams.id;

    $http.get('/movies/movieDetail', {
        params: {id: movieId, category: category}
    }).success(function (data, status, headers, config) {
        $scope.movieDetails = data;

        var imdbId = $scope.movieDetails.imdbId;

        $http.get('http://www.omdbapi.com/', {
            params: {i: imdbId, plot: "short", r: "json"} //"tt0816692"
        }).success(function (data, status, headers, config) {
            $scope.ratingImdb = data;



        var votes = $scope.ratingImdb.imdbRating; //var votes = $scope.movieDetails.votes;
        $rootScope.movieTitle = data.title;

        if (votes.toString().length >= 3) {
            $scope.voteRate = votes.toString().substring(0, 3);
            var arr = votes.toString().substring(0, 3).split('.');
        }
        else {
            votes = votes.toString() + ".0";
            $scope.voteRate = votes;
            var arr = votes.split('.');
        }

        if (arr[1] > 5) {
            $scope.ratingFullStar = parseInt(arr[0]) + 1;

            if ($scope.ratingFullStar != null) {
                $scope.ratingEmptyStar = 10 - $scope.ratingFullStar;
                $scope.ratingHalfStar = 0;
            }
            else {
                $scope.ratingEmptyStar = 10;
                $scope.ratingHalfStar = 0;
            }
        }
        else if (arr[1] < 5) {
            $scope.ratingFullStar = parseInt(arr[0]);

            if ($scope.ratingFullStar != null) {
                $scope.ratingEmptyStar = 10 - $scope.ratingFullStar;
                $scope.ratingHalfStar = 0;
            }
            else {
                $scope.ratingEmptyStar = 10;
                $scope.ratingHalfStar = 0;
            }
        }
        else if (arr[1] == 5) {
            $scope.ratingFullStar = parseInt(arr[0]);

            if ($scope.ratingFullStar != null) {
                $scope.ratingEmptyStar = 9 - $scope.ratingFullStar;
                $scope.ratingHalfStar = 1;
            }
            else {
                $scope.ratingEmptyStar = 9;
                $scope.ratingHalfStar = 1;
            }
        }

        $scope.getNumber = function (num) {
            return new Array(num);
        }
    });

});
}

/**
 * The movie controller - lists all movies (Lazy Loading)
 * @param $scope
 * @param $http
 * @param $routeParams
 * @constructor
 */
function MovieController($scope, $http, $rootScope) {
    var category = document.documentURI.substring(40, document.documentURI.length);
    $rootScope.movieCategory = category;
    var pageNumber = "";
    $scope.page = 1;


    console.log(category);


    $http.get('/movies', {
        params:{category: category}
    }).success(function (data, status, headers, config) {
        $scope.numberOfPages = data;


        pageNumber = $scope.numberOfPages.toString();
        $scope.allPages = parseInt(pageNumber/5);

        document.getElementById("allMovies").style.display = "block";
        document.getElementById("allRadio").style.display = "none";
        document.getElementById("mainNav").style.display = "none";
        document.getElementById("vitabox-category").innerHTML = "Movies";


        $http.get('/movies/pages', {
            params: {category: category, pageNumber: $scope.page}
        }).success(function (data, status, headers, config) {
            $scope.movielist = data;


            $scope.nextPage = function() {

                if ($scope.page < $scope.allPages) {

                    $scope.page = $scope.page + 1;

                    $http.get('/movies/pages', {
                        params: {category: category, pageNumber: $scope.page}
                    }).success(function (data, status, headers, config) {
                        $scope.movielist = data;
                        console.dir($scope.movielist);

                    });
                }

            };


            $scope.previousPage = function() {

                if (($scope.page < pageNumber/5) && ($scope.page > 1)) {

                    $scope.page = $scope.page - 1;

                    $http.get('/movies/pages', {
                        params: {category: category, pageNumber: $scope.page}
                    }).success(function (data, status, headers, config) {
                        $scope.movielist = data;
                        console.dir($scope.movielist);

                    });
                }

            };

        });

    });

}


/*
 Populates main navigation menu
 */
function mainNavigationController($scope, $http) {

    $http.get('/navigation/mainNavigation', {cache: true}).success(function (data, status, headers, config) {
        $scope.links = data;
    });

    //navigation functions
    $scope.navigate = function () {
        console.log("Navigating");
    }
}

/**
 * Populates all movies navigation menu
 * @param $scope
 * @param $http
 */
function allMoviesNavigationController($scope, $http) {
    $http.get('/navigation/allMoviesNavigation', {cache: true}).success(function (data, status, headers, config) {
        $scope.allMovieLinks = data;
    });
    //navigation functions
    $scope.navigate = function () {
        console.log("Navigating all movies");
    }
}

/**
 * The movie trailer controller - gets trailer id from the url and uses youtube api
 * @param $scope
 * @param $routeParams
 * @param $http
 * @param $sce
 */
function movieTrailerController($scope, $routeParams, $http, $sce) {
    var trailerURL = $routeParams.trailerURL;

    $http.get('/movies/movieTrailer', {
        params: {trailerURL: trailerURL}
    }).success(function (data, status, headers, config) {
        var youtubeUrl = "https://www.youtube.com/embed/" + data + "?rel=0";
        $scope.youtubeUrl = youtubeUrl;
    });
}

/**
 * The movie player controller - gets movie id from the url and uses opensubtitles api
 * @param $scope
 * @param $routeParams
 * @param $http
 * @param $sce
 */
function playMovieController($scope, $routeParams, $http, $rootScope) {
    var movieId = $routeParams.id.substring(2,$routeParams.id.length);
    var tmdbId = $rootScope.tmdbId;

    $http.get('/movies/FindSubs', {
        params: {id: movieId}
    }).success(function (data, status, headers, config) {
        $scope.subtitles = data;

        console.dir($scope.subtitles);
    });
    $http.get('/movies/movieInfo', {
        params: {id: tmdbId}
    }).success(function (data, status, headers, config) {
        $scope.movieInfo = data;

        console.dir($scope.movieInfo);
    });


    ////$http.get('localhost:80/torrentClient?', {
    //  //  params: {id: movieId}
    ////}).success(function (data, status, headers, config) {
    //   // $scope,movieInfo = data;/
    //
    //    console.dir($scope.subtitles);
    //});

}


/*
 Populate movie player
 */
function moviePlayerController($scope, $http, $routeParams) {
    var movieId = $routeParams.movieId;
    $http.get('/movies/playMovie', {
        params: {movieId: movieId, subssubsLang: $scope.Lang, captionLang: $scope.captionLang}
    }).success(function (data, status, headers, config) {
        $scope.videoplayer = data;
    });

}

/**
 * Populates all radios navigation menu
 * @param $scope
 * @param $http
 */
function allRadiosNavigationController($scope, $http) {

    $http.get('/navigation/allRadioNavigation', {cache: true}).success(function (data, status, headers, config) {
        $scope.allRadioLinks = data;
    });

}

/**
 * The radios controller - lists all radios
 * @param $scope
 * @param $http
 * @param $rootScope
 * @constructor
 */
function RadioController($scope, $http, $rootScope){
    var category = document.documentURI.substr(39,document.documentURI.length);
    $rootScope.radioCategory = category;

    $http.get('/music', {
        params:{category: category}
    }).success(function (data, status, headers, config) {
        $scope.radiolist = data;

        document.getElementById("allRadio").style.display = "block";
        document.getElementById("allMovies").style.display = "none";
        document.getElementById("mainNav").style.display = "none";
        document.getElementById("vitabox-category").innerHTML = "Radio";

    })

}
