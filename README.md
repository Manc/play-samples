# Learning to use Play Framework 2 with Scala and MongoDB

This is supposed to become a loose collection of various Play Framework (Scala) samples.

Check the Wiki for a [list of samples](https://github.com/Manc/play-samples/wiki) currently available.


## Learn and Contribute

Whether you're learining Play and Scala yourself right now or you're already an expert and willing to help, please fork this repository, play with the code yourself, enhance it, send pull requests.


## Background

I come from a PHP background and think it's time to learn something new. After some research I decided that I want to learn Scala and learn to build websites and APIs using [Play Framework 2](http://www.playframework.com/). I've also been interested in [MongoDB](http://www.mongodb.org/) for some time although I never had the opportunity to use it in a real-life project.

To be honest, I'm not the type of guy who can read a book about such a topic from start to finish. I've got certain problems that I want to solve in my head and I want to get straight into it. I quickly found out that the lerning curve is quite steep for Scala, especially if you didn't have to care too much about data types in the past. There are also a lot of funny characters in Scala code (%, %%, _, @…), that I find quite difficult to understand straigh away.

I created this repository to solve some general problems that many web developers come accross very often, which includes dealing with user input, data validation, storing and retrieving data in a database (MongoDB in my case), but I also want to learn about more specific topics like accessing foreign APIs, Amazon Web Services, image manipulation and a lot more.

I find, some tutorials are too basic and not practical or safe enough for a real application and others are too difficult to understand (for someone with PHP background). I'll do it step by step and hopefully the code of this repository will grow and others will benefit from it, too. I'll try to use a lot of comments in the code so everyone who's new to Scala and Play can understand more easily what's going on.


## Documentation

As said before, I will try to use comments in the code as much as possible. An installation and/or usage guide will follow at some point. This project has just started.

Basically you should have Play Framework and MongoDB installed on your local machine. There are a lot of tutorials that explain how to do that. Personally, I develop on a Mac and installed everything with [Homebrew](http://brew.sh/) – it's great and makes the installation a lot things very easy. I've not tried it yet myself, but you should just download/pull the content of this repository, go to its folder and run `play`, then enter `run` and open `http://localhost:9000` in your browser. Then you should see the index page with a list or samples available.

> Make sure to initialise the submodules, too. You should have at least a folder `vendor` containing Twitter Bootstrap (maybe more at some point in the future). This directory is required for the app to compile, because we include some of the LESS files from `app/assets/stylesheets/main.less`.


## Versions Currently Used

* Play Framework 2.2.1 (built with Scala 2.10.2)
* MongoDB 2.4.8
* Casbah 2.6.4
* Salat 1.9.4
