# JSON vs XML: What is the difference?
> JSON is a data interchange format and only provides a data encoding specification. XML is a language to specify custom markup languages, and provides a lot more than data interchange.

JSON and XML fulfil a similar purpose of organizing complex data in an understandable and readable format to various APIs (Application Programming Interfaces) and programming languages. This type of technology is essential because **structuring the data is what allows us to share it successfully**.

# XML
- XML = Extensible Markup Language = a markup language and file format for storing, transmitting, and reconstructing arbitrary data defined by a set of rules for encoding documents in a format that is both human-readable and machine-readable

**XML IS NOT HTML!!**

XML is extensible. It lets you define your own tags, the order in which they occur, and how they should be processed or displayed. Another way to think about extensibility is to consider that XML allows all of us to extend our notion of what a document is: it can be a file that lives on a file server, or it can be a transient piece of data that flows between two computer systems (as in the case of Web Services).


Example of XML syntax:
```xml
<note>
    <to>James</to>
    <from>Harvey</from>
    <heading>Reminder</heading>
    <body>Don't forget about the meeting on Monday!</body>
</note>
```

## Key Concepts
* elements
- An XML element is everything from (including) the element's start tag to (including) the element's end tag:
```xml
<to name="sender">James<date>2022-05-14</date></to>
```
- An element can contain text (ex. James), attributes (ex. name), or other elements(ex. date).

* attributes
- Attributes are designed to contain data related to a specific element

* namespaces
- XML Namespaces provide a method to avoid element name conflicts
- Name conflicts in XML can easily be avoided using a name prefix
ex.
```xml
<h:table>
  <h:tr>
    <h:td>Apples</h:td>
    <h:td>Bananas</h:td>
  </h:tr>
</h:table>

<f:table>
  <f:name>African Coffee Table</f:name>
  <f:width>80</f:width>
  <f:length>120</f:length>
</f:table>
```
<br>

- For more info about XML, go to these references:
- [XML Tutorial for Beginners](https://www.youtube.com/watch?v=n-y-YHVZSwk)
- [MDN article on XML](https://developer.mozilla.org/en-US/docs/Web/XML/XML_introduction)
- [W3Schools Tutorial on XML](https://www.w3schools.com/xml/default.asp)

# JSON
- JSON = JavaScript Object Notation
- JSON data is written as name/value pairs (aka key/value pairs)
- A name/value pair consists of a field name (in double quotes), followed by a colon, followed by a value:

Example of JSON syntax:
```json
{
    "name": "John",
    "age": 23,
    "job": "Software Developer",
    "hobbies": ["hiking", "jogging", "cooking"]
}
```
- keys must be in double quotes
- values must be one of the following data types:
    - string
    - number
    - object
    - array
    - boolean
    - null

- For more info about JSON, check out these resources:
    - [JSON Overview](https://www.json.org/json-en.html)
    - [JSON Formatter & Validator Tool](https://jsonformatter.curiousconcept.com/)
    - [FreeCodeCamp - Learn JSON](https://www.youtube.com/watch?v=GpOO5iKzOmY)
    - [JSON Crash Course](https://www.youtube.com/watch?v=wI1CWzNtE-M)

# JWTs
- A JWT is a structured security token format used to encode JSON data. The main reason to use JWT is to exchange JSON data in a way that can be cryptographically verified. 
- JWTs can be verified and trusted because it is digitally signed. JWTs can be signed using a secret (with the HMAC algorithm) or a public/private key pair using RSA or ECDSA.
- In its compact form, JSON Web Tokens consist of three parts separated by dots (.), which are:
    - Header (x) = contains the type of the token(JWT) + the signing algorithm being used(HMAC SHA256 or RSA)
    - Payload (y) = contains the claims, which are statements about an entity (typically, the user) and additional data, in an encoded Base64Url format
    - Signature (z) = takes the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that

ex.
```
xxxxx.yyyyy.zzzzz
```

- For more info about JWTs, visit these resources:
    - [A Beginner's Guide to JWTs](https://developer.okta.com/blog/2020/12/21/beginners-guide-to-jwt)
    - [JWT Intro](https://jwt.io/introduction)
    - [Tutorial: Create and Verify JWTs in Java](https://developer.okta.com/blog/2018/10/31/jwts-with-java)