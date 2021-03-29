## Idea
The main idea is to create RESTful Web service to creating training plans for workout at home only with bodyweight, 
which can be used by someone else.  

## MVP Scope
As a user, I want to have a set of exercises with ability to create my training plans and save them.

## How it would work
Based on MVP Scope, we can specify next behaviours:

    User can choise way to use service: with Web client or with telegram
    User can sing up and sing in to his profil
    User can view list of exercises and create trainings plans
    User can create a schedular trainings 
    User can active Telebram bot to gets reminders about trainings
    User can get random training or challenge

## Technological stack

    * SpringBoot as a skeleton framework
    * Spring Scheduler as a task manager
    * PostgreSQL database as a database for saving info about users
    * Spring Data starter
    * Spring Web for working with REST calls
    * Telegram-bot SpringBoot starter 

## Release Notes
Can be found in [RELEASE_NOTES](RELEASE_NOTES.md).

## Authors
* Mykola Kostyshyn - [mikkiko](https://github.com/mikkiko)

##Acknowledgments
...

## Contributing
Please, follow [Contributing](CONTRIBUTING.md) page.

## Code of Conduct
Please, follow [Code of Conduct](CODE_OF_CONDUCT.md) page.

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details
