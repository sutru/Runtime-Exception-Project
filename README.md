#  Team RunTime Exception Design Document

## Instructions


## Horrible Meme Horoscope Design

## 1. Problem Statement

*Users around the world have fallen in love with social media platforms such as Twitter, Instagram, Facebook, etc. Our 
goal is to first create a website comparable to these, then add our own twist to it by adding in horoscopes. First off we need to 
create a website that users can use to enjoy, share, and save memes.*


## 2. Top Questions to Resolve in Review

*List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.*

1. Whether to use meme Api or internal links.
2. Is it possible to use Cognito with DynamoDB
3. How do we implement the idea of a horoscope

## 3. Use Cases

*This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.*


U1. As a user, I want to be able to get a meme I choose.

U2. As a user, I want to be able to get a random meme.

U3. As a user, I want to be able to save the generated meme into my list of saved memes.

U4. As a user, I want to be able to send the generated meme to others via multiple platforms.


## 4. Project Scope

*Clarify which parts of the problem you intend to solve. It helps reviewers know
what questions to ask to make sure you are solving for what you say and stops
discussions from getting sidetracked by aspects you do not intend to handle in
your design.*

### 4.1. In Scope

*Which parts of the problem defined in Sections 1 and 2 will you solve with this
design?*

* Retrieve a picture from a database and display
* Only display pictures related to the User's interests
* The ability to save pictures to the users account
* send pictures to other users

### 4.2. Out of Scope

* Users will not be able to add their own picture
* Users will not be able to comment on pictures
* Users do not have the ability to send comments with pictures
* Users do not have the ability to create their own tags

# 5. Proposed Architecture Overview

We have decided to build out our own API because if we were to use a built out API we would not have much work to do, as 
for dynamoDB with cognito we know that it is possible from surface level research.
Regarding the horoscope we could add a **See your daily meme** button on the main page, that finds a meme based on their
horoscope

###[Api Design](project_documents/HorribleMemeHoroscope.html)

We are building a social media platform and in order to do so we have to at bare minimum: get an image to our frontend, 
have a list of saved images that can be retrieved from, and update that saved list. As the project is being built we hope
to discover new features to add such as horoscope memes.

# 6. API

## 6.1. Public Models


`UserModel` - Contains Cognito Id and list of preferences

`MemeModel` - Contains memeName, possibly unique Asin, Url

## 6.2. *First Endpoint*

### Grab a meme
there are two get methods here one with a memes name and the other with no meme name, the former takes a path parameter 
to grab an image url by its name the latter just grabs a random meme. 



## 6.3 *Second Endpoint*

###Get a list of saved memes
grabs the list of saved memes associated with the user

###Update a list of saved memes
updates the list associated with the user takes an email and an url to add or remove from the list

# 7. Tables



###User Table
email (partition_key) : String

Password : String






###Meme Table
memeName (sort_key) : String

imageLink (partition_key) : String


###Meme Liked List Table
email (partition_key) : String

imageLinkList : List







# 8. Pages


###[Website sketch](Frontend-sketch.html)
###[Api Design](project_documents/HorribleMemeHoroscope.html)