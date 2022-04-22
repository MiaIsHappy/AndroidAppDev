# AndroidAppDev
I am creating an Android Mobile App while learning Android development.

Week 1 Add buttons and textview, and adjust layout. Use toast to display messages

Week 3 Add new activity, Add 6 buttons and display them in constraint layout; Handle display rotation

Week 4 Add Link Collector that brings up a new activity. 
       Add floating action button. Add RecyclerView to display a list of items in the app 
       Make sure the list display well when app display is rotated
       Use snackbar to display message
       
Week 5 Use location service. Display latitude and longitude.
       Ask user's permission when using the location service
       
Week 6 Use a web API. Send a request to and get a response from the web service.
       I used a weather API. User can enter a zip code. The app displays the weather, temperature, UV level, 
       city name, state of the zip code.
       
Week 7 8 9 
       1. we use Firebase Realtime Database to create an app to send a sticker to a specific friend who also has the app. we will use your predefined "stickers" (images) that users tap on instead of letting the user type emojis with the keyboard.
2. we display how many of each sticker a user has sent because a future version of the app might have users purchase those stickers that they send, and the stickers might have different costs.  Show each user a history of stickers that they have received (which sticker was sent and who sent it and when it was sent). 
       3. The app adjust with different screen size. Not everyone has the same size screen, and not everyone holds their device the same orientation.  If the user rotates the device, reload the activity data so that the user stays smoothly on the same screen. 
       4. We build the app with Firebase Realtime Database and notifications without using Firebase Cloud Messaging.  We experiment with the receiving app running in the foreground and in the background.
       5. The app notify the user in a way that recognizes the message  That is, go beyond just text in your notification.  If you aren't sure what can be in a notification other than text, refer to this https://developer.android.com/guide/topics/ui/notifiers/notifications#Templates
       6. Every instance of your app of the same version will have that same series of images in its resources.  Each image has a unique identifier.  Send the unique identifier that identifies an image, not the actual pixels of the image.
       We will complete and test this prototype project in April 2022. 
