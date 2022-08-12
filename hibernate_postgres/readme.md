### Notes

The goal is just to get an idea of what a postgres implementation would look like - I'm not sure about how versed everyone is with JPA, but it's good to review

- this is a psuedo implementation of the localize Team,Project, Strings, Translation DAO
- there are many STUBS here - just to keep the implementation somewhat close to what's there
- I've reall just implemented the basic crud stuff 
  - controller
  - request objects
  - response objects
  - model
  - repository
- I was about to look at including hibernate query "Criteria" becuase I think the search fields come in the filter argument, instead of having more targeted hard-coded search criteris
- I incorporated a few small ideas (Documents instead of Subprojects) and tags that are from commercial implementation
- 
