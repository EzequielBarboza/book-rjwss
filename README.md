This is supposed to run on Jboss 7.3

Maven install causes wildfly deploy


Change the wildfly execution - Reference: https://docs.jboss.org/wildfly/plugins/maven/latest/examples/complex-example.html


Why you cannot use jboss-as-maven plugin: https://issues.redhat.com/browse/WFLY-3684


Add github key to windows: https://www.pluralsight.com/guides/using-git-and-github-on-windows


Run jboss in debug mode:
standalone.bat --debug 9797

---

Test:
curl --digest -uusername:username123! http://localhost:7080/a-product-idea/services/person/1


Concepts:
JSSE
