<!-- ABOUT THE PROJECT -->
# assesment project - code challenge

## Problem Statement

This project includes 1st and 2nd challenges of the assesment project code challenge.

The name of the database is Mobile Devices.
The data is taken from assesment project - code challenge repository's devices.json file.
Validation options is decided by challenge.
Mobile devices has four field.
id : The unique number of the mobile devices that saved to database.
brand : The brand of the mobile device.
model : The model of the mobile device.
os : The operating system of the mobile device.
osVersion : The operating system version of the mobile device.

### Logical requirements of first challenge
- When the device data is posted to backend, it must be validated before saved to database.
- If the posted data is valid, it must be saved to database and it's database id must return in response.

### Logical requirements of second challenge
- If no filter parameter provided, all devices data must return with Page response
- If filter parameter(s) provided only matching devices data must return in response
  - Single filter with single parameter can be provided. e.g. brand is **Samsung**
  - Multiple filters with single parameter in each can be provided. Logical operation between different filters must be **and**. e.g. brand is **Apple** *and* osVersion is **12.2**
  - response must be containing the devices data matching to the requested page.
  
  An example request will be as follows:
  `/devices?brand=apple&osVersion=9&page=3`
