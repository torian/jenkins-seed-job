
def repository = 'ansible-role-filebeat'

def branches = [ 'master', 'development' ]

branches.each { branch ->

  job("${repository}-${branch}") {
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
        branch("$branch")
      }
    }

    steps {
      shell("""
      echo "Hello World"
      """.stripIndent())
    }
  }

}
