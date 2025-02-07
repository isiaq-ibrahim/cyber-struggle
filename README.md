# Cyber Struggle Mobile

During my internship at Cyber Struggle in Fall of 2024, I built a vulnerable Android mobile application demonstrating several common vulnerabilities in Android applications such as:
1. 🔑 Hardcoded credentials of sensitive information (e.g., default developer username/password)
2. 🚪 Insecure authentication bypass
3. 🖊️ Code injection vulnerabilities
4. 📥 Malicious intent filters
5. ⏳ Insufficient session management
6. 🔍 Reverse engineering and code tampering

One of the critical issues I addressed in this project is the widespread use of hardcoded strings in Android apps. These strings, often embedded within code, may include API keys, user credentials, encryption keys, and server configurations. While convenient, they pose serious security risks, which developers sometimes overlook.

One dangerous vulnerability I implemented is a code injection flaw that executes arbitrary user input via:
Runtime.getRuntime().exec(userCode);.

This vulnerability is a real eye-opener, as it demonstrates the severe risk of poorly sanitized user inputs. In this case, malicious input could potentially lead to wiping the device memory—an impactful reminder of the consequences of insecure coding practices.

My internship at Cyber Struggle was an enriching experience, offering a blend of technical knowledge and personal growth. Throughout the internship, I gained invaluable insights into both the cybersecurity industry and workplace dynamics, which have prepared me for my future career. Below are some key lessons I learned:
1. Understanding Vulnerabilities: One of the most significant technical lessons I learned was identifying, exploiting, and mitigating vulnerabilities in mobile applications. By working on the vulnerable mobile app, I gained firsthand experience with issues like authentication bypass, code injection, and session management flaws, all of which are critical in modern-day application security.
2. Secure Coding Practices: Developing a vulnerable app made me acutely aware of the importance of secure coding practices. I learned how even small mistakes in code design can lead to major security risks. This helped me understand best practices for session management, encryption techniques, and input validation to prevent exploitation.
3. Reverse Engineering Prevention: I became proficient in using tools and methods to protect applications from reverse engineering and code tampering, which are vital skills in the cybersecurity field. I applied code obfuscation techniques and explored certificate pinning to strengthen the security of apps.
4. Cybersecurity Tools: I worked with different cybersecurity tools and technologies, including Android Studio, Burp Suite, ApkEditor, and APKTool, to analyze and test vulnerabilities. This broadened my practical knowledge of how these tools are used in real-world penetration testing.
