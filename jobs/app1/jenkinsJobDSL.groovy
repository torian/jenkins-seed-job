
def repository = 'ansible-role-filebeat'

def branches = [ 'master', 'development' ]

branches.each { b ->

  job("${repository}-${b}") {
    triggers {
      scm('* * * * *')
    }

    scm {
      git {
        remote {
          github("torian/$repository", 'https')
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
