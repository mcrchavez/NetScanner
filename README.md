# NetScanner
## Java program used for network scanning and enumeration  




### *PingSweeper* 
- Sends TCP Queries -- pings -- to specified IP addresses on network to enumerate through active devices

### *PortScanner* 
- Attempts to form socket with each port on IP address to return open ports on IP 




<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

[![LinkedIn][linkedin-shield]][linkedin-url]










<!-- ABOUT THE PROJECT -->
## About The Project

I initially created this project for my own uses in penetration testing and network enumeration. I am planning to implement a verbose and interactive command line enviroment to better visualize network mapping techniques.

<!--[![Product Name Screen Shot][product-screenshot]](https://example.com)-->



### Built With

* [![picocli](https://img.shields.io/badge/picocli-4.6.1-green.svg)](https://github.com/remkop/picocli)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

* JVM and JDK 8 or later


### Installation

Clone the repo
   ```sh
   git clone https://github.com/mcrchavez/NetScanner.git
   ```
   <!--
2. Install NPM packages
   ```sh
   npm install
   ```
   -->



<!-- USAGE EXAMPLES -->
## Usage
Enter install directory
 ```sh
   cd User\Downloads\NetScanner\src
   ```
Compile and run with java classpath
   ```sh
   javac -cp "User\Downloads\NetScanner\lib\picocli-4.6.1.jar" .; NetScanner.java
   ```
   ```sh
   java -cp "C:\PersonalProjects\NetScanner\lib\picocli-4.6.1.jar" .; NetScanner --help
   ```








<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Michael Chavez - mcrchavez713@gmail.com

Project Link: [https://github.com/mcrchavez/NetScanner](https://github.com/mcrchavez/NetScanner)







<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/mcrchavez/repo.svg?style=for-the-badge
[contributors-url]: https://github.com/mcrchavez/repo/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mcrchavez/repo.svg?style=for-the-badge
[forks-url]: https://github.com/mcrchavez/repo/network/members
[stars-shield]: https://img.shields.io/github/stars/mcrchavez/repo.svg?style=for-the-badge
[stars-url]: https://github.com/mcrchavez/repo/stargazers
[issues-shield]: https://img.shields.io/github/issues/mcrchavez/repo.svg?style=for-the-badge
[issues-url]: https://github.com/mcrchavez/repo/issues
[license-shield]: https://img.shields.io/github/license/mcrchavez/repo.svg?style=for-the-badge
[license-url]: https://github.com/mcrchavez/repo/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/michael-chavez-804687206
