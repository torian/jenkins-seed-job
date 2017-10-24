
String repository = 'app1'

def branches = [ 'master', 'development' ]

branches.each { branch ->

  job('$repository-$branch') {
    triggers {
      scm('* * * * *')
    }

    scm {
      git {
        remote {
          github("torian/$repo", 'https')
          //credentials()
          //refspec('+refs/pull/*:refs/remotes/origin/pr/*')
        }
        branch(branch)
      }
    }

    steps {
      shell("""
      echo "Hello World"
      """.stripIndent())
    }
  }

}
