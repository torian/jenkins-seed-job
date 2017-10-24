String repo = 'jenkins-seed-job'

job('seed-1') {
  triggers {
    scm('* * * * *')
  }

  scm {
    git {
      remote {
        github("torian/$repo", 'https')
        //credentials()
      }
      branch('master')
    }
  }

  steps {
    dsl {
      external('jobs/**/*DSL.groovy')
    }
  }
}
