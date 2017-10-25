
def repository = 'test-repo'

def branches = [ 'master', 'development' ]

branches.each { b ->

  job("${repository}-${b}") {
    triggers {
      scm('* * * * *')
    }

    scm {
      git("file:///vagrant/git/$repository")
    }

    steps {
      shell("""
      echo "Hello World"
      """.stripIndent())
    }
  }

}
