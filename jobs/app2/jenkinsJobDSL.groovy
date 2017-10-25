
def repository = 'test-repo'

def branches = [ 'master', 'development' ]

branches.each { b ->

  job("${repository}-${b}") {
    triggers {
      scm('* * * * *')
    }

    scm {
      git {
        remote {
          git("file:///vagrant/git/$repository")
          //credentials()
          //refspec('+refs/pull/*:refs/remotes/origin/pr/*')
        }
        branch(b)
      }
    }

    steps {
      shell("""
      echo "Hello World"
      """.stripIndent())
    }
  }

}
