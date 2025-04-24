# Youtube Selenium Test Automation

## Test Scenario Description

### Preconditions

-  Created an account Google

### Scenario #1: Like the Video and Subscribe the Channel

1. Go to [Youtube.com](https://www.youtube.com/) and verify correct page title.
2. Click on the "Sign In" button.
3. Enter the email and click "Next" button.
4. Enter the password and click "Next" button.
5. Search for "Java Testing with Selenium Course".
6. Click on the first video in the search results.
7. Pause the Video.
8. Click "Like" button and verify button pressed status. 
9. Click "Subscribe" button and verify subscription text.
10. Open Channel Page in the new Tab.

### Scenario #2: Login to Google Account

1. Go to [Youtube.com](https://www.youtube.com/) and verify correct page title.
2. Click on the "Sign In" button.
3. Enter the email and click "Next" button.
4. Enter the password and click "Next" button.
5. Click the "Trending" button in the Explore section.
6. Switch to "Music" tab.
7. Click on the 10th video.
8. Sort the comments by "Newest first".
9. Enter comment and submit!
10. Verify that the comment appears first in the list.


## Test Run

To execute tests in the project with Test Runner, use the following command:
``` sh
mvn clean test -Denv={dev,qa} -Dbrowser={browser} -Dtest=TestRunner
```

To execute tests in the project with specific Tag, use the following command:
``` sh
mvn clean test -Denv={dev,qa} -Dbrowser={browser} -D"cucumber.filter.tags={tag}"
```

**Supported browsers:**
- Local (format: {browser}_local)
  - Edge 
  - Firefox 
  - Chrome (*default*)
- Remote (Docker Grid) (format: {browser}_remote)
  - Firefox
  - Chrome (*default*)

**Tags:**
- @SmokeTest
- @RegressionTest

## Acceptance criteria
- The scenarios are linear (no need to implement complex logic for now). 3 scenarios in total.
- Different locator strategies are used for a task.
- Usage of auto-generated locators is avoided.
- WebDriver API is widely used.
- Different methods of waits are used.
- Test scenarios are clear, stable and good structured.
- Each method in test scenario has assertions.
- Page Objects have consistent structure (decomposition of PO is right).
- Test scenarios are clear, stable and good structured.
- There is at least one level of inheritance between pages (Abstract Page exists).
- There is no code duplication at all.
- Inner implementation of PO is hidden from tests.
- Naming and Code Conventions should be followed.



