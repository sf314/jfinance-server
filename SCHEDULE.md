# Release Schedule

The following are the changes that are intended to be released for the 
specified version tags. This schedule may change at any time. 


## 0.0.0 - Initial Release
This represents a clean starting state of the repository, with no logic apart 
from the default files and classes required to run. 


## 0.1.0 - Health and User endpoints defined 
This represents a fully functional REST server for both health and user 
endpoints. Not all user endpoints will be defined at this point, but some base
functionality with the resource objects and templated values will be available.

No Business logic is to be involved. 


## 0.2.0 - Transaction endpoints defined
This represents the development of base endpoints related to all anticipated 
transactions that users should perform. These should be aligned to user stories.
At a minimum, users should be able to add and remove transcactions, and view a 
summary of a given week's spending by category.


## 0.3.0 - Business layer defined
This represents the development of the business layer for all endpoints. While
default or empty values can be returned, it is important that it correctly 
provides data to the endpoints. This also involves the creation of all data 
transfer objects. 


## 0.4.0 - In-memory DAO 
This represents the creation of a data layer capable of serving the business 
layer above it. Rather than interacting with permanent storage, this release
will represent stored data as in-memory lists accessed in a static manner. 


## 0.5.0 - File-based DAO 
This represents the creation of a DAO that can interact with the filesystem
to ensure that data is persistent across multiple instances. This will involve
creating several utility classes regarding file parsing and data converstion.

## 0.6.0 - Swagger and documentation
This represents a more non-functional release whereby all endpoints contain 
Swagger documentation (or some other equivalent) so that an easy summary of 
the service can be viewed by potential downstream clients. 

## 0.9.1 - Unit tests
This represents the completion of unit tests for all essential classes. 
Ideally, happy-path unit tests will be written alongside the code, but this
release shall cover all branch paths. 


## 1.0.0 - Full functionality 
This represents the completion of the JFinance Server, such that it is ready for 
production release and use by client applications, such as iOS apps and web 
clients. 